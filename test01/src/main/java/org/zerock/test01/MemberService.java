package org.zerock.test01;

import org.modelmapper.ModelMapper;
import org.zerock.test01.dto.MemberDTO;
import org.zerock.test01.domain.MemberVO;
import org.zerock.test01.util.MapperUtil;

import java.util.List;
import java.util.stream.Collectors;

public enum MemberService {

    INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService() {
        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public void register(MemberDTO memberDTO) throws Exception {

       MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
       System.out.println("memberVO: " + memberVO);

       dao.insert(memberVO);
    }

    public List<MemberDTO> list() throws Exception {

        List<MemberVO> voList = dao.selectAll();
        System.out.println(voList);

        List<MemberDTO> memberDTOList = voList.stream()
                .map(vo -> modelMapper.map(vo, MemberDTO.class))
                .collect(Collectors.toList());

        return memberDTOList;
    }

    public MemberDTO getOne(Long tno) throws Exception {

        System.out.println("tno: " + tno);

        MemberVO memberVO = dao.selectOne(tno);
        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);

        return memberDTO;
    }

    public void modify(MemberDTO memberDTO) throws Exception {

        System.out.println("memberDTO: " + memberDTO);

        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);

        dao.updateOne(memberVO);
    }

    public void remove(Long tno) throws Exception {

        System.out.println("tno: " + tno);

        dao.deleteOne(tno);
    }

}
