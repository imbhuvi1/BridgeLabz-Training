package com.app.fundoo.specification;

import com.app.fundoo.entity.Note;
import org.springframework.data.jpa.domain.Specification;

public class NoteSpecification {

    public static Specification<Note> hasUserId(Long userId) {
        return (root, query, cb) -> cb.equal(root.get("userId"), userId);
    }

    public static Specification<Note> isNotDeleted() {
        return (root, query, cb) -> cb.isFalse(root.get("isDeleted"));
    }

    public static Specification<Note> titleContains(String keyword) {
        return (root, query, cb) ->
                keyword == null ? null : cb.like(cb.lower(root.get("title")), "%" + keyword.toLowerCase() + "%");
    }

    public static Specification<Note> hasColor(String color) {
        return (root, query, cb) ->
                color == null ? null : cb.equal(root.get("color"), color);
    }

    public static Specification<Note> isPinned(Boolean pinned) {
        return (root, query, cb) ->
                pinned == null ? null : cb.equal(root.get("isPinned"), pinned);
    }

    public static Specification<Note> isArchived(Boolean archived) {
        return (root, query, cb) ->
                archived == null ? null : cb.equal(root.get("isArchived"), archived);
    }
}