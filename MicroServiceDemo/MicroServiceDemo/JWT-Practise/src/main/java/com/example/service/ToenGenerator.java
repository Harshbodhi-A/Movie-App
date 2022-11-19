package com.example.service;

import com.example.model.User;

import java.util.Map;

public interface ToenGenerator {
    Map<String,String> generateToen(User user);
}
