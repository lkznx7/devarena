package com.devarena.shared.utils;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

public class SlugUtil {
    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

    public static String generateSlug(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("O título não pode ser vazio para gerar um slug");
        }
        String nowhitespace = WHITESPACE.matcher(input.trim()).replaceAll("-").toLowerCase(Locale.ENGLISH);
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.replaceAll("-{2,}", "-");
    }
}
