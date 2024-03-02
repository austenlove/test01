import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.zerock.test01.MemberDAO;
import org.zerock.test01.domain.MemberVO;

import java.util.List;


public class DAOTests {

    private MemberDAO memberDAO;

    @BeforeEach
    public void ready() {
        memberDAO = new MemberDAO();
    }

    @Test
    public void testInsert() throws Exception {

        MemberVO memberVO = MemberVO.builder()
                .id("SampleUser")
                .pw("1111")
                .age(25)
                .gender("여자")
                .hobby("test")
                .travel("test")
                .content("Sample Content.....")
                .build();

        memberDAO.insert(memberVO);
    }

    @Test
    public void testSelectAll() throws Exception {

        List<MemberVO> list = memberDAO.selectAll();

        list.forEach(vo -> System.out.println(vo));
    }

    @Test
    public void testSelectOne() throws Exception {

        Long tno = 4L;

        MemberVO memberVO = memberDAO.selectOne(tno);

        System.out.println(memberVO);
    }

    @Test
    public void testUpdateOne() throws Exception {

        MemberVO memberVO = MemberVO.builder()
                .tno(5L)
                .name("뉴진스 혜인")
                .id("Hyein")
                .pw("1234")
                .age(15)
                .gender("여자")
                .hobby("잠자기, 공부하기")
                .travel("괌")
                .content("update 테스트")
                .build();

        memberDAO.updateOne(memberVO);
    }


}
