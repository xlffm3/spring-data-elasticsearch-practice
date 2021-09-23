package com.example.elasticsearch.user.domain.search;

import com.example.elasticsearch.user.domain.User;
import java.util.List;

public interface CustomUserSearchRepository {

    List<User> searchByName(String name);
}
