package com.example.mongo;

import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.MongoDBAtlasVectorStore;
import org.springframework.ai.vectorstore.MongoDBAtlasVectorStore.MongoDBVectorStoreConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@Configuration
public class VectorStoreConfig {

    @Bean
    public MongoDBAtlasVectorStore mongodbVectorStore(MongoTemplate mongoTemplate
            , EmbeddingModel embeddingModel)
    {
        MongoDBVectorStoreConfig config = MongoDBVectorStoreConfig.builder()
                .withCollectionName("documents")
                .withVectorIndexName("vector_index")
                .withPathName("embedding")
                .withMetadataFieldsToFilter(List.of("author", "type", "title", "date"))
                .build();

        return new MongoDBAtlasVectorStore(mongoTemplate, embeddingModel
                , config, false);
    }
}
