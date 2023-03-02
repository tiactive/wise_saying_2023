package com.ll;

import com.ll.system.controller.SystemController;
import com.ll.wiseSaying.controller.WiseSayingController;
import com.ll.wiseSaying.entity.WiseSaying;

import java.util.*;

public class App {
    public void run() {
        System.out.println("== 명언 앱 ==");
        long lastWiseSayingId = 0;
        List<WiseSaying> wiseSayings = new ArrayList<>();

        SystemController systemController = new SystemController();
        WiseSayingController wiseSayingController = new WiseSayingController(Container.getScanner());

        while(true) {
            System.out.print("명령) ");
            String command = Container.getScanner().nextLine().trim();
            if (command.equals("종료")) {
                systemController.exit();
                break;
            } else if (command.equals("등록")) {
                wiseSayingController.write();
            } else if (command.equals("목록")) {
                wiseSayingController.list();
            } else if (command.startsWith("삭제")) {
                // 정리 시작
                // 삭제?id=1&authorName="홍길동) 이런 형식
                String[] commandBits = command.split("\\?", 2);
                String actionCode = commandBits[0];
                Map<String, String> params = new HashMap<>();
                String[] paramBits = commandBits[1].split("&");
                for(String paramStr:paramBits) {
                    String[] paramStrBits = paramStr.split("=", 2);
                    String key = paramStrBits[0];
                    String value = paramStrBits[1];
                    params.put(key,value);
                }
                // 정리 끝
                wiseSayingController.remove();
            }
        }
    }
}

