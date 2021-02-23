package com.lkb.service.goods;

import java.util.Map;

public interface SkuSearchService {

    /**
     * elasticsearch接口
     */
        public Map search(Map<String, String> searchMap);
    public Map show(Map<String, String> searchMap);

}
