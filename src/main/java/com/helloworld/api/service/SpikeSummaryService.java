package com.helloworld.api.service;

import com.helloworld.api.dto.SpikeSummaryRequest;
import com.helloworld.api.dto.SpikeSummaryResponse;
import com.helloworld.api.model.SpikeSummary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SpikeSummaryService {
    
    /**
     * Get spike summary data based on request parameters
     * 
     * @param request The spike summary request containing filter parameters
     * @return List of spike summary responses
     */
    public List<SpikeSummaryResponse> getSpikeSummary(SpikeSummaryRequest request) {
        // This is a placeholder implementation
        // In a real application, this would fetch data from a database or external service
        List<SpikeSummary> summaries = fetchSpikeSummaryData(request);
        
        return summaries.stream()
                .map(this::mapToResponse)
                .toList();
    }
    
    /**
     * Fetch spike summary data from data source
     * This is a placeholder method that would typically query a database
     * 
     * @param request The request parameters for filtering
     * @return List of spike summary models
     */
    private List<SpikeSummary> fetchSpikeSummaryData(SpikeSummaryRequest request) {
        // Placeholder implementation returning sample data
        List<SpikeSummary> summaries = new ArrayList<>();
        
        SpikeSummary summary = SpikeSummary.builder()
                .category(request.getCategory())
                .market(request.getMarket())
                .periodStartTime(request.getDetectedTime())
                .pool("POOL_001")
                .tac(12345678)
                .sip408(10)
                .sip480(5)
                .sip481(3)
                .sip500(8)
                .sip503(12)
                .sip504(7)
                .others(15)
                .total(60)
                .build();
        
        summaries.add(summary);
        
        return summaries;
    }
    
    /**
     * Map SpikeSummary model to SpikeSummaryResponse DTO
     * 
     * @param summary The spike summary model
     * @return The spike summary response DTO
     */
    private SpikeSummaryResponse mapToResponse(SpikeSummary summary) {
        return SpikeSummaryResponse.builder()
                .category(summary.getCategory())
                .market(summary.getMarket())
                .periodStartTime(summary.getPeriodStartTime())
                .pool(summary.getPool())
                .tac(summary.getTac())
                .sip408(summary.getSip408())
                .sip480(summary.getSip480())
                .sip481(summary.getSip481())
                .sip500(summary.getSip500())
                .sip503(summary.getSip503())
                .sip504(summary.getSip504())
                .others(summary.getOthers())
                .total(summary.getTotal())
                .build();
    }
}
