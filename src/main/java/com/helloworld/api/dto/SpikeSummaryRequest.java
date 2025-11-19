package com.helloworld.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpikeSummaryRequest {
    @NotBlank(message = "MARKET is required")
    private String market;
    
    @NotBlank(message = "CATEGORY is required")
    private String category;
    
    @NotNull(message = "DETECTED_TIME is required")
    private LocalDateTime detectedTime;
    
    @NotBlank(message = "VENDOR is required")
    private String vendor;
}
