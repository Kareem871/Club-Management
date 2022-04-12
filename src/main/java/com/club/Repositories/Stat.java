package com.club.Repositories;

import java.math.BigDecimal;

public interface Stat {
    int getSum();
    BigDecimal getMonth();
    BigDecimal getYear();
    int getVisitors();
}
