package com.campbell.service;

import com.campbell.ReviewApplicationTests;
import com.campbell.constants.Grade;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author Campbell
 * @date 2020/7/31
 */
@Slf4j
public class ChooseTest extends ReviewApplicationTests {

    /**
     * switch选择语句
     */
    @Test
    public void testSwitch() {
        while (true) {
            System.out.println("请输入年级：");
            int i = 0;
            try {
                i = new Scanner(System.in).nextInt();
            } catch (Exception e) {
                log.error("error", e);
            }
            String gradeName;
            switch (i) {
                case Grade.GRADE_ONE_CODE:
                    gradeName = Grade.GRADE_ONE_NAME;
                    break;
                case Grade.GRADE_TWO_CODE:
                    gradeName = Grade.GRADE_TWO_NAME;
                    break;
                case Grade.GRADE_THREE_CODE:
                    gradeName = Grade.GRADE_THREE_NAME;
                    break;
                case Grade.GRADE_FOUR_CODE:
                    gradeName = Grade.GRADE_FOUR_NAME;
                    break;
                case Grade.GRADE_FIVE_CODE:
                    gradeName = Grade.GRADE_FIVE_NAME;
                    break;
                case Grade.GRADE_SIX_CODE:
                    gradeName = Grade.GRADE_SIX_NAME;
                    break;
                default:
                    gradeName = null;
                    break;
            }
            log.info(gradeName);
            if (i == 3) {
                break;
            }
        }
    }

}
