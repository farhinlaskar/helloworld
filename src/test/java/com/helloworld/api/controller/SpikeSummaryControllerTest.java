package com.helloworld.api.controller;

import com.helloworld.api.dto.SpikeSummaryResponse;
import com.helloworld.api.service.SpikeSummaryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SpikeSummaryController.class)
class SpikeSummaryControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private SpikeSummaryService spikeSummaryService;
    
    @Test
    void testGetSpikeSummary() throws Exception {
        // Arrange
        SpikeSummaryResponse response = SpikeSummaryResponse.builder()
                .category("VOICE")
                .market("US")
                .periodStartTime(LocalDateTime.of(2025, 11, 19, 14, 40, 11))
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
        
        List<SpikeSummaryResponse> responses = Collections.singletonList(response);
        
        when(spikeSummaryService.getSpikeSummary(any())).thenReturn(responses);
        
        // Act & Assert
        mockMvc.perform(get("/sip/spike-summary")
                .param("MARKET", "US")
                .param("CATEGORY", "VOICE")
                .param("DETECTED_TIME", "2025-11-19T14:40:11")
                .param("VENDOR", "VENDOR_A"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].MARKET").value("US"))
                .andExpect(jsonPath("$[0].CATEGORY").value("VOICE"))
                .andExpect(jsonPath("$[0].POOL").value("POOL_001"))
                .andExpect(jsonPath("$[0].TAC").value(12345678))
                .andExpect(jsonPath("$[0].TOTAL").value(60));
    }
    
    @Test
    void testGetSpikeSummaryWithDifferentParameters() throws Exception {
        // Arrange
        SpikeSummaryResponse response = SpikeSummaryResponse.builder()
                .category("DATA")
                .market("EU")
                .periodStartTime(LocalDateTime.of(2025, 11, 19, 10, 30, 0))
                .pool("POOL_002")
                .tac(87654321)
                .sip408(20)
                .sip480(10)
                .sip481(6)
                .sip500(16)
                .sip503(24)
                .sip504(14)
                .others(30)
                .total(120)
                .build();
        
        List<SpikeSummaryResponse> responses = Collections.singletonList(response);
        
        when(spikeSummaryService.getSpikeSummary(any())).thenReturn(responses);
        
        // Act & Assert
        mockMvc.perform(get("/sip/spike-summary")
                .param("MARKET", "EU")
                .param("CATEGORY", "DATA")
                .param("DETECTED_TIME", "2025-11-19T10:30:00")
                .param("VENDOR", "VENDOR_B"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].MARKET").value("EU"))
                .andExpect(jsonPath("$[0].CATEGORY").value("DATA"))
                .andExpect(jsonPath("$[0].POOL").value("POOL_002"))
                .andExpect(jsonPath("$[0].TAC").value(87654321))
                .andExpect(jsonPath("$[0].TOTAL").value(120));
    }
}
