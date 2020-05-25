package com.sdy.design;

import java.util.Collection;
import java.util.Map;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author: Sun Deyu
 * @date: 2020/5/25 11:44
 * @description: Observer 注册表
 */
public class ObserverRegistry {
    private ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();

    public void register(Observer observer) {
        Map<Class<?>, Collection<ObserverAction>> observerAction = findAllObserverAction(observer);
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerAction.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> eventActions = entry.getValue();
            CopyOnWriteArraySet<ObserverAction> registerEventActions = registry.get(eventType);
            if (registerEventActions == null) {
                registry.putIfAbsent(eventType, new CopyOnWriteArraySet<>());
                registerEventActions = registry.get(eventType);
            }
            registerEventActions.addAll(eventActions);
        }
    }

    private Map<Class<?>, Collection<ObserverAction>> findAllObserverAction(Observer observer) {
        // todo
        return null;
    }
}
