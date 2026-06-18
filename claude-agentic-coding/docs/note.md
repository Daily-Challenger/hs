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