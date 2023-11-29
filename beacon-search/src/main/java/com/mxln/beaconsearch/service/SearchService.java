package com.mxln.beaconsearch.service;

import java.io.IOException;

/**
 *
 */
public interface SearchService {

    /**
     * 向es中添加一行文档
     * @param index
     * @param id
     * @param json
     */
    void index(String index,String id,String json) throws IOException;

}
