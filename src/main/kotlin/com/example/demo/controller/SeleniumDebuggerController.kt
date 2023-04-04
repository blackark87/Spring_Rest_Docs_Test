package com.example.demo.controller

import com.example.demo.service.SeleniumDebuggerService
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/debugger")
@RequiredArgsConstructor
class SeleniumDebuggerController(private val seleniumDebuggerService: SeleniumDebuggerService) {

    @PostMapping("/openAndClose")
    fun openAndCloseUrl(@RequestParam url: String) {
        seleniumDebuggerService.openAndCloseUrl(url)
    }

    @PostMapping("/runAllTests")
    fun runAllTests(@RequestParam url: String) {
        seleniumDebuggerService.runAllTests(url)
    }
}