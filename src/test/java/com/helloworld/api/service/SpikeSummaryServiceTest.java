package com.helloworld.api.service;

import com.helloworld.api.dto.SpikeSummaryRequest;
import com.helloworld.api.dto.SpikeSummaryResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SpikeSummaryServiceTest {
    
    @InjectMocks
    private SpikeSummaryService spikeSummaryService;
    
    @Test
    void testGetSpikeSummary() {
        // Arrange
        SpikeSummaryRequest request = SpikeSummaryRequest.builder()
                .market("US")
                .category("VOICE")
                .detectedTime(LocalDateTime.of(2025, 11, 19, 14, 40, 11))
                .vendor("VENDOR_A")
                .build();
        
        // Act
        List<SpikeSummaryResponse> responses = spikeSummaryService.getSpikeSummary(request);
        
        // Assert
        assertNotNull(responses);
        assertFalse(responses.isEmpty());
        assertEquals(1, responses.size());
        
        SpikeSummaryResponse response = responses.get(0);
        assertEquals("US", response.getMarket());
        assertEquals("VOICE", response.getCategory());
        assertNotNull(response.getPeriodStartTime());
        assertNotNull(response.getPool());
        assertNotNull(response.getTac());
        assertNotNull(response.getTotal());
    }
    
    @Test
    void testGetSpikeSummaryWithDifferentParameters() {
        // Arrange
        SpikeSummaryRequest request = SpikeSummaryRequest.builder()
                .market("EU")
                .category("DATA")
                .detectedTime(LocalDateTime.of(2025, 11, 19, 10, 30, 0))
                .vendor("VENDOR_B")
                .build();
        
        // Act
        List<SpikeSummaryResponse> responses = spikeSummaryService.getSpikeSummary(request);
        
        // Assert
        assertNotNull(responses);
        assertFalse(responses.isEmpty());
        
        SpikeSummaryResponse response = responses.get(0);
        assertEquals("EU", response.getMarket());
        assertEquals("DATA", response.getCategory());
    }
}
