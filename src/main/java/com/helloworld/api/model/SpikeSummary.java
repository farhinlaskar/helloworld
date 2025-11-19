package com.helloworld.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpikeSummary {
    private String category;
    private String market;
    private LocalDateTime periodStartTime;
    private String pool;
    private Integer tac;
    private Integer sip408;
    private Integer sip480;
    private Integer sip481;
    private Integer sip500;
    private Integer sip503;
    private Integer sip504;
    private Integer others;
    private Integer total;
}
