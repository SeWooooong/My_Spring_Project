package com.example.my_spring_project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JUnitTest {
    @DisplayName("1 + 2는 3이다")
    @Test
    public void junitTest(){
        int a = 1;
        int b = 2;
        int sum = 3;
        assertThat(a+b).isEqualTo(sum);
    }
}
