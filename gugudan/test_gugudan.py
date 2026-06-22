import pytest
from gugudan import multiply, get_table, format_table


class TestMultiply:
    def test_multiply_basic(self):
        assert multiply(3, 4) == 12
        assert multiply(5, 6) == 30
        assert multiply(7, 8) == 56

    def test_multiply_boundary(self):
        assert multiply(2, 1) == 2
        assert multiply(9, 9) == 81

    def test_multiply_invalid_dan(self):
        with pytest.raises(ValueError):
            multiply(1, 5)
        with pytest.raises(ValueError):
            multiply(10, 5)

    def test_multiply_invalid_num(self):
        with pytest.raises(ValueError):
            multiply(3, 0)
        with pytest.raises(ValueError):
            multiply(3, 10)


class TestGetTable:
    def test_get_table_length(self):
        assert len(get_table(2)) == 9
        assert len(get_table(9)) == 9

    def test_get_table_values(self):
        table = get_table(3)
        assert table[0] == (1, 3)
        assert table[4] == (5, 15)
        assert table[8] == (9, 27)

    def test_get_table_invalid_dan(self):
        with pytest.raises(ValueError):
            get_table(1)
        with pytest.raises(ValueError):
            get_table(10)


class TestFormatTable:
    def test_format_table_contains(self):
        result = format_table(4)
        assert "4 x 1 = 4" in result
        assert "4 x 5 = 20" in result
        assert "4 x 9 = 36" in result

    def test_format_table_line_count(self):
        result = format_table(5)
        assert len(result.strip().splitlines()) == 9
