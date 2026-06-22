def multiply(dan: int, num: int) -> int:
    """단(2~9)과 수(1~9)를 곱한 값을 반환한다."""
    if dan < 2 or dan > 9:
        raise ValueError(f"단은 2~9 사이여야 합니다. (입력값: {dan})")
    if num < 1 or num > 9:
        raise ValueError(f"수는 1~9 사이여야 합니다. (입력값: {num})")
    return dan * num


def get_table(dan: int) -> list[tuple[int, int]]:
    """특정 단의 곱셈 결과를 (수, 결과) 튜플 리스트로 반환한다."""
    if dan < 2 or dan > 9:
        raise ValueError(f"단은 2~9 사이여야 합니다. (입력값: {dan})")
    return [(num, multiply(dan, num)) for num in range(1, 10)]


def format_table(dan: int) -> str:
    """특정 단을 문자열로 포맷하여 반환한다."""
    lines = [f"{dan} x {num} = {result}" for num, result in get_table(dan)]
    return "\n".join(lines)


def print_all() -> None:
    """2~9단 전체를 출력한다."""
    for dan in range(2, 10):
        print(format_table(dan))
        print()


if __name__ == "__main__":
    print_all()
