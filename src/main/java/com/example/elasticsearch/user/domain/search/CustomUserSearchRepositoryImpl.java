package com.example.elasticsearch.user.domain.search;

import com.example.elasticsearch.user.domain.User;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomUserSearchRepositoryImpl implements CustomUserSearchRepository {

    private final ElasticsearchOperations elasticsearchOperations;

    @Override
    public List<User> searchByName(String name) {
        Criteria criteria = Criteria.where("basicProfile.name").contains(name);
        Query query = new CriteriaQuery(criteria);
        SearchHits<User> search = elasticsearchOperations.search(query, User.class);
        return search.stream()
            .map(SearchHit::getContent)
            .collect(Collectors.toList());
    }
}
