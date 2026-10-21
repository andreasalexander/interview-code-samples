package com.example.orders.dto;

import java.time.Instant;

public record OrderResponse(Long id, Instant placedAt) {}
