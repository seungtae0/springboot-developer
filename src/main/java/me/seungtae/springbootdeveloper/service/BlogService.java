package me.seungtae.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.seungtae.springbootdeveloper.domain.Article;
import me.seungtae.springbootdeveloper.dto.AddArticleRequest;
import me.seungtae.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }
}
