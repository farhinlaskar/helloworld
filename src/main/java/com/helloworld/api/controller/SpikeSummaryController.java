package com.helloworld.api.controller;

import com.helloworld.api.dto.SpikeSummaryRequest;
import com.helloworld.api.dto.SpikeSummaryResponse;
import com.helloworld.api.service.SpikeSummaryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sip")
public class SpikeSummaryController {
    
    private final SpikeSummaryService spikeSummaryService;
    
    @Autowired
    public SpikeSummaryController(SpikeSummaryService spikeSummaryService) {
        this.spikeSummaryService = spikeSummaryService;
    }
    
    /**
     * Get spike summary endpoint
     * 
     * @param market The market parameter
     * @param category The category parameter
     * @param detectedTime The detected time in ISO 8601 format
     * @param vendor The vendor parameter
     * @return List of spike summary responses
     */
    @GetMapping("/spike-summary")
    public ResponseEntity<List<SpikeSummaryResponse>> getSpikeSummary(
            @RequestParam(name = "MARKET") String market,
            @RequestParam(name = "CATEGORY") String category,
            @RequestParam(name = "DETECTED_TIME") String detectedTime,
            @RequestParam(name = "VENDOR") String vendor) {
        
        SpikeSummaryRequest request = SpikeSummaryRequest.builder()
                .market(market)
                .category(category)
                .detectedTime(java.time.LocalDateTime.parse(detectedTime))
                .vendor(vendor)
                .build();
        
        List<SpikeSummaryResponse> responses = spikeSummaryService.getSpikeSummary(request);
        
        return ResponseEntity.ok(responses);
    }
}
