package com.protosstechnology.train.bootexamine.responsitory;

import com.protosstechnology.train.bootexamine.Entity.Document;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DocumentRepository extends PagingAndSortingRepository<Document,Long> {
}
