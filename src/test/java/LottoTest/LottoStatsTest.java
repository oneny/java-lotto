package LottoTest;

import lotto.domain.LottoGameResult;
import lotto.domain.LottoStats;
import lotto.domain.Rank;
import lotto.domain.RankingRecord;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoStatsTest {
    @Test
    void Given_LottoGameResults_When_New_Then_StatsInstanceCreated() {
        //given
        List<LottoGameResult> lottoGameResults = Arrays.asList(
                new LottoGameResult(3)
        );

        //when then
        assertDoesNotThrow(() -> new LottoStats(lottoGameResults));
    }

    @Test
    void When_Rank_Then_RankReturn() {
        //given
        List<LottoGameResult> lottoGameResults = Arrays.asList(
                new LottoGameResult(3),
                new LottoGameResult(3),
                new LottoGameResult(6)
        );

        LottoStats lottoStats = new LottoStats(lottoGameResults);

        //when
        RankingRecord rank = lottoStats.record(Rank.FORTH);

        //then
        assertThat(rank.winners()).isEqualTo(2);
    }

    @Test
    void Given_LottoGameResults_When_Yield_Then_CalculatedYield() {
        //gvien
        List<LottoGameResult> lottoGameResults = Arrays.asList(
                new LottoGameResult(0),
                new LottoGameResult(0),
                new LottoGameResult(0),
                new LottoGameResult(0),
                new LottoGameResult(0),
                new LottoGameResult(3)
        );
        LottoStats lottoStats = new LottoStats(lottoGameResults);


        //when
        double yield = lottoStats.yield();

        //then
        assertThat(yield).isEqualTo(5000 / 6000);
    }

}
