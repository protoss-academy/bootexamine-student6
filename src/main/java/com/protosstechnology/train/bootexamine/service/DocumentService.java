package com.protosstechnology.train.bootexamine.service;

import com.protosstechnology.train.bootexamine.Entity.Document;

public interface DocumentService {
    public void create(Document user);
    public Document read(Long id);
    public Document update(Document user);
    public void delete(Long id);
}
