#### 관련 링크
https://code.claude.com/docs/ko

https://claude.com/blog/building-agents-with-the-claude-agent-sdk

---
#### 에이전틱 AI
- 스스로 문제를 분석하고 도구를 활용하여 자율적으로 작업을 수행하는 AI 시스템

#### MCP(Model Context Protocol)
- AI 모델이 외부 데이터나 도구와 상호작용할 수 있도록 하는 프로토콜
(예, 클로드로 구글드라이브 문서읽기)

#### 에이전틱 코딩
1. 탐색: Plan Mode 입력
2. 계획: 상세 구현 계획 작성
3. 검증: Plan Mode 종료 계획 검증
4. 커밋: 메세지 커밋, PR 생성

**Plan Mode**?
- 코드를 수정하거나 실행하지 않고, 코드베이스를 분석하여 구현 계획을 작성해 주는 읽기 전용 분석 기능

#### 클로드 코드의 동작원리
- 컨텍스트 수집, 작업 수행, 결과검증 세 단계를 거침
- 내장 도구 카테고리

|  |  |
| --- | --- |
| 파일 조작 | Read, Write, Edit, MultiEdit |
| 검색 | Glob, Grep |
| 쉘 실행 | Bash |
| 웹 접근 | WebFetch, WebSearch |


#### context window
- 한번의 추론에서 참조할 수 있는 토큰의 총량
- 관리전략
1. compaction: 이전 대화 요약
2. /clear: 대화 기록 초기화
3. progressive disclosure: 가벼운 식별자(파일 경로, 링크) 만 유지하다가 필요할 때 도구를 데이터로 동적 로드. Skills 시스템이 이 원칙을 따름
4. subagent: 서브 에이전트가 메인 에이전트와 별도로 독립된 컨텍스트 윈도를 사용하는 것을 활용
5. 구조화된 메모 작성: md파일로 체크리스트 작성 후 필요할 때 호출

#### 다섯가지 접근권한
- 내장도구 접근 대상: 파일시스템, 터미널, 웹, MCP서버, 에디터 컨텍스트

#### 4대 핵심 기능
1. 자연어 기반의 기능 구축
2. 심층 디버깅 및 문제 해결
3. 코드베이스 탐색과 분석
4. 반복 태스크 자동화

#### 팀 협업 설정 파일 버전 관리
- .claude/commands 디렉터리에 프롬프트 템플릿을 저장하면 팀원이 '슬래시 명령' 으로 공통 워크플로를 호출 할 수 있음
- CLAUDE.md 에 프로젝트 코드 스타일 가이드라인, 테스트 절차 등을 기록하면 자동으로 참조

#### 클로드 코드의 다섯 가지 확장도구

1. 스킬
 - 무엇을 알고 있는가
2. 서브에이전트
 - 무엇을 할 수 있는가
3. MCP 서버
 - 외부 세계와 연결하는 통로
4. 훅
5. 플러그인
 - 앞의 4가지를 하나의 배포 단위로 묶는 컨테이너
 - .claude-plugin/plugin.json 매니페스트를 통해 메타데이터를 정의


 #### IAM 권한 관리
 1. 클로드 API 인증: 
 - 클로드 콘솔을 통해 앤트로픽의 API에 접근하는 방식
 - 역할: 클로드 코드, Developer
2. 아마존 배드락 인증
 - AWS 인프라를 사용하는 조직
 - CLAUDE_CODE_USE_BEDROCK 환경 변수를 설정
3. 구글 버텍스 AI 인증
 - GCP 사용 
 - CLAUDE_CODE_USE_VERTEX

- `/permissions` 명령으로 현재 적용된 모든 권한 규칙을 확인 및 관리

```
#Read와 Edit 규칙이 지원하는 경로 패턴
- //path: 시스템 root의 절대경로
- ~/path: 홈 디렉토리의 경로
- /path: {설저 파일 위치}/src/**/*.js
- path 또는 .path: {현재 디렉토리}/*.env
```

- WebFetch: 도메인 단위로 네트어크 접근 제어
- MCP 도구에 대한 권한
 1. mcp_puppeteer: puppeteer 서버의 모든 도구
 2. mcp_puppeteer__puppeteer_navigate: 서버내 특정 도구



#### 에이전트 스킬
```
#스킬 디렉터리의 기본구조
my-skill
ㄴ SKILL.md(필수 파일)
ㄴ reference.md
ㄴ scripts/
    ㄴ helper.py
ㄴ templates/
    ㄴ template.txt
```

#### SKILL.md 구조
 - 프론트매터 필드: name. description, allowed-tools, model, context, agent


#### SKILL 을 활용한 비용 최적화
1. description 의 토큰 밀도를 극대화 -> 최대한의 발견 가능성 확보
2. 클로드가 이미 알고 있는 지식은 제거.
3. 지원 파일의 구조를 도메인별로 분리.
4. 입출력 예시 최적화(대표만 명시. 나머지는 별도 md파일로)
5. 스크립트 우선 전략

- 스킬 조합 시 유사한 기능의 스킬이 동시에 활성화 될 수 있으므로 고유한 트리거 용어를 description에 지정(예, 데이터처리 -> Excel 시트 분석)

#### 스킬 개발 순서
1. 스킬 목적과 범위를 명확히 정의
2. 스킬 디렉터리 생성
3. SKILL.md 파일 작성
4. 지원 파일 추가

#### 스크립트를 포함한 스킬 디렉터리 구조
```
skill/
├── SKILL.md
├── reference.md
├── scripts/
│   ├── format_data.py
│   └── requirements.txt
└── templates/
    └── result_template.json

```

#### skill의 점진적 작동 방식
1. 핵심원칙(SKILL.md)
2. 가이드,기법(reference)
3. 템플릿

#### 재사용 가능한 스킬 패턴 유형
1. 프로젝트 특화 패턴
 - 프로젝트 아키텍처
 - 명명 규칙
 - 코딩 스타일
2. 도메인 특화패턴
 - 리액트 컴포넌트
 - 장고모델
 - Fest API 엔드 포인트
3. 범용 유틸리티
 - 코드리뷰
 - 문서생성
 - 테스트 작성ㄴㄴㄴ