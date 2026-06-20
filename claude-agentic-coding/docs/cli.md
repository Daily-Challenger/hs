### 버전관리
- 안정버전(기본값): curl -fsSL https://claude.ai/install.sh | bash
- 최신 기능: curl -fsSL https://claude.ai/install.sh | bash -s latest
- 특정 버전: curl -fsSL https://claude.ai/install.sh | bash -s 2.0.75

###  자동업데이트 비활성화
```
$ export DISABLE_AUTOUPDATER=1
```

### 설정 디렉토리
```
project-root/
├── .cluade/
│   ├── commands/             # 커스텀 슬래시 명령어
│   ├── agents/               # 커스텀 에이전트 정의
│   ├── skills/               # 에이전트 스킬 모듈
│   ├── hooks/                # 이벤트 훅 스크립트
│   ├── output-styles/        # 출력 스타일 템플릿
│   └── setting.json          # 프로젝트별 클로드 코드 설정
└── CLAUDE.md                 # 프로젝트 지침서(컨텍스트로 자동 로드)
```

### 실행방법
```
- 일회성 작업: claude "질문"
- 비대화형 쿼리: claude -p
- 최근대화 세션 재개: claude -c
- 이전 대화 세션 중 선택 재개: claude -r
```

### 명령어
- /clear: 현재 대화 컨텍스트 초기화. 프로젝트 설정과 체크포인트 유지 되므로 /rewind로 이전 상태 복구 가능
- claude doctor: 정상 설치 여부 확인. 설치 유형, 경로, 상태 등을 진단하여 출력