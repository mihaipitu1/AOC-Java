package com.mpitu.adventofcodesolution.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Point2D {
    private Integer row;
    private Integer col;
}
