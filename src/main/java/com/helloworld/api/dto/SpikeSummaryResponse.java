package com.helloworld.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpikeSummaryResponse {
    @JsonProperty("CATEGORY")
    private String category;
    
    @JsonProperty("MARKET")
    private String market;
    
    @JsonProperty("PERIOD_START_TIME")
    private LocalDateTime periodStartTime;
    
    @JsonProperty("POOL")
    private String pool;
    
    @JsonProperty("TAC")
    private Integer tac;
    
    @JsonProperty("SIP_408")
    private Integer sip408;
    
    @JsonProperty("SIP_480")
    private Integer sip480;
    
    @JsonProperty("SIP_481")
    private Integer sip481;
    
    @JsonProperty("SIP_500")
    private Integer sip500;
    
    @JsonProperty("SIP_503")
    private Integer sip503;
    
    @JsonProperty("SIP_504")
    private Integer sip504;
    
    @JsonProperty("OTHERS")
    private Integer others;
    
    @JsonProperty("TOTAL")
    private Integer total;
}
