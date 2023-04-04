package com.example.demo.controller

import com.example.demo.service.SeleniumDebuggerService
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.operation.preprocess.Preprocessors.*
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(SpringExtension::class)
@WebMvcTest(SeleniumDebuggerController::class)
@AutoConfigureRestDocs(outputDir = "build/generated-snippets")
class SeleniumDebuggerControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var seleniumDebuggerService: SeleniumDebuggerService

    @Test
    fun openAndCloseUrl() {
        val url = "https://www.google.com"
        Mockito.`when`(seleniumDebuggerService.openAndCloseUrl(url)).thenReturn("test")
        mockMvc.perform(post("/api/debugger/openAndClose").param("url",url))
            .andExpect(status().isOk)
            .andDo(
                document("openAndCloseUrl",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint())
                    )
            )
    }

    @Test
    fun runAllTests() {
        val url = "https://www.google.com"
        Mockito.`when`(seleniumDebuggerService.runAllTests(url)).thenReturn("test")
        mockMvc.perform(post("/api/debugger/runAllTests").param("url",url))
            .andExpect(status().isOk)
            .andDo(
                document("runAllTests",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint())
                )
            )
    }
}