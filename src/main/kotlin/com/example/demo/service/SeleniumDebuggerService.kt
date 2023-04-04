package com.example.demo.service

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.springframework.stereotype.Service

@Service
class SeleniumDebuggerService {

    private val options: ChromeOptions = ChromeOptions().addArguments("--remote-allow-origins=*")
    private val driver: WebDriver = ChromeDriver(options)

    fun openAndCloseUrl(url: String): String {
        driver.get(url)
        val title = driver.title
        driver.quit()

        return title

    }

    fun runAllTests(url: String): String {
        driver.get(url)
        val title = driver.title
        driver.quit()

        return title
    }
}