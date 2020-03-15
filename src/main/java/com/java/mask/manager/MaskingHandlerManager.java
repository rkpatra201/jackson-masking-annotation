package com.java.mask.manager;

import com.java.mask.handler.IMaskingHandler;

import java.util.HashMap;
import java.util.Map;

public class MaskingHandlerManager {

    private static final MaskingHandlerManager INSTANCE =
            new MaskingHandlerManager();
    private Map<String, IMaskingHandler> maskingHandlers = new HashMap<String, IMaskingHandler>();

    public void addHandler(String key, IMaskingHandler handler) {
        maskingHandlers.put(key, handler);
    }

    public IMaskingHandler getHandler(String key) {
        return maskingHandlers.get(key);
    }

    private MaskingHandlerManager() {
        // no-code
    }

    public static MaskingHandlerManager getInstance() {
        return INSTANCE;
    }
}
