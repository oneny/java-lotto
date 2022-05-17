package lotto.domain.constant;

import java.util.Arrays;

public enum Rank {
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000),
    NONE(0, 0);

    private final int correspondCount;
    private final int prizeMoney;

    Rank(int correspondCount, int prizeMoney) {
        this.correspondCount = correspondCount;
        this.prizeMoney = prizeMoney;
    }

    public static Rank create(int correspondCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.correspondCount == correspondCount)
                .findAny()
                .orElse(NONE);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getCorrespondCount() {
        return correspondCount;
    }
}
