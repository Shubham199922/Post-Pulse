package com.example.demo.projection;

import java.time.Instant;

public interface BlogProjection {
public Integer getId();
public String getName();
public String getTitle();
public Instant getCreateDate();
public Instant getUpdateDate();
}
