/*
 * FXGL - JavaFX Game Library. The MIT License (MIT).
 * Copyright (c) AlmasB (almaslvl@gmail.com).
 * See LICENSE for details.
 */

package com.almasb.fxgl.service;

import com.almasb.fxgl.app.FXGLExceptionHandler;
import com.almasb.fxgl.service.impl.display.FXGLDisplay;
import com.almasb.fxgl.service.impl.executor.FXGLExecutor;
import com.almasb.fxgl.service.impl.net.FXGLNet;
import com.google.inject.Scope;
import com.google.inject.Scopes;

/**
 * Marks a service type.
 * A service is a single aspect of FXGL that is accessible globally
 * and has a single instance per application.
 * A service only knows about EventBus and does not know about other services
 * or other things like game world, game scene, etc.
 *
 * @author Almas Baimagambetov (AlmasB) (almaslvl@gmail.com)
 */
public interface ServiceType<T> {

    /**
     * @return service interface/class
     */
    Class<T> service();

    /**
     * @return service implementation/provider
     */
    Class<? extends T> serviceProvider();

    /**
     * @return service scope
     */
    default Scope scope() {
        return Scopes.SINGLETON;
    }

    ServiceType<Display> DISPLAY = new ServiceType<Display>() {
        @Override
        public Class<Display> service() {
            return Display.class;
        }

        @Override
        public Class<? extends Display> serviceProvider() {
            return FXGLDisplay.class;
        }
    };

    ServiceType<Executor> EXECUTOR = new ServiceType<Executor>() {
        @Override
        public Class<Executor> service() {
            return Executor.class;
        }

        @Override
        public Class<? extends Executor> serviceProvider() {
            return FXGLExecutor.class;
        }
    };

    ServiceType<Net> NET = new ServiceType<Net>() {
        @Override
        public Class<Net> service() {
            return Net.class;
        }

        @Override
        public Class<? extends Net> serviceProvider() {
            return FXGLNet.class;
        }
    };

    ServiceType<ExceptionHandler> EXCEPTION_HANDLER = new ServiceType<ExceptionHandler>() {
        @Override
        public Class<ExceptionHandler> service() {
            return ExceptionHandler.class;
        }

        @Override
        public Class<? extends ExceptionHandler> serviceProvider() {
            return FXGLExceptionHandler.class;
        }
    };
}
