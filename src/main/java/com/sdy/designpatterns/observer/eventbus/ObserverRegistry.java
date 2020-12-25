package com.sdy.designpatterns.observer.eventbus;

import com.google.common.base.Preconditions;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author: sundy
 * @date: 2020/12/24 19:13
 * @description: Observer 注册表
 */
public class ObserverRegistry {
    private ConcurrentMap<Class<?>, CopyOnWriteArraySet> registry = new ConcurrentHashMap<>();

    public void register(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(observer);
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerActions.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            CopyOnWriteArraySet<ObserverAction> registeredEventActions = registry.get(eventType);
            if (registeredEventActions == null) {
                registry.putIfAbsent(eventType, new CopyOnWriteArraySet<>());
                registeredEventActions = registry.get(eventType);
            }
            registeredEventActions.addAll(eventActions);
        }
    }

    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();
        Class<?> clazz = observer.getClass();
        for (Method method : getAnnotatedMethods(clazz)) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> eventType = parameterTypes[0];
            if (!observerActions.containsKey(eventType)) {
                observerActions.put(eventType, new ArrayList<>());
            }
            observerActions.get(eventType).add(new ObserverAction(observer, method));
        }
        return observerActions;
    }

    private List<Method> getAnnotatedMethods(Class<?> clazz) {
        List<Method> annotatedMethods = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            // if (!method.isAnnotationPresent(Subscribe.class)) {
            //     continue;
            // }
            Class<?>[] parameterTypes = method.getParameterTypes();
            Preconditions.checkArgument(parameterTypes.length == 1,
                    "Method %s has @Subscribe annotation but has %s parameters."
                            + "Subscriber methods must have exactly 1 parameter."
                    , method, parameterTypes.length);
            annotatedMethods.add(method);
        }
        return annotatedMethods;
    }

    public List<ObserverAction> getMatchedObserverActions(Object event) {
        List<ObserverAction> matchedObservers = new ArrayList<>();
        Class<?> postedEventType = event.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet> entry : registry.entrySet()) {
            Class<?> eventType = entry.getKey();
            CopyOnWriteArraySet<ObserverAction> eventActions = entry.getValue();
            // 父类.class.isAssignableFrom(子类.class)
            // 子类实例 instanceof 父类类型
            if (eventType.isAssignableFrom(postedEventType)) {
                matchedObservers.addAll(eventActions);
            }
        }
        return matchedObservers;
    }
}