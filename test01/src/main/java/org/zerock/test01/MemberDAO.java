package org.zerock.test01;

import lombok.Cleanup;
import org.zerock.test01.util.ConnectionUtil;
import org.zerock.test01.domain.MemberVO;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class MemberDAO {


    public void insert(MemberVO memberVO) throws Exception {

        String sql = "insert into test_member(name, id, pw, age, gender, hobby, travel, content) values (?,?,?,?,?,?,?,?)";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, memberVO.getName());
        preparedStatement.setString(2, memberVO.getId());
        preparedStatement.setString(3, memberVO.getPw());
        preparedStatement.setInt(4, memberVO.getAge());
        preparedStatement.setString(5, memberVO.getGender());
        preparedStatement.setString(6, memberVO.getHobby());
        preparedStatement.setString(7, memberVO.getTravel());
        preparedStatement.setString(8, memberVO.getContent());

        preparedStatement.executeUpdate();
    }


    public List<MemberVO> selectAll() throws Exception {

        String sql = "select * from test_member";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        List<MemberVO> list = new ArrayList<>();

        while(resultSet.next()) {
            MemberVO memberVO = MemberVO.builder()
                    .tno(resultSet.getLong("tno"))
                    .name(resultSet.getString("name"))
                    .id(resultSet.getString("id"))
                    .pw(resultSet.getString("pw"))
                    .age(resultSet.getInt("age"))
                    .gender(resultSet.getString("gender"))
                    .hobby(resultSet.getString("hobby"))
                    .travel(resultSet.getString("travel"))
                    .content(resultSet.getString("content"))
                    .build();

            list.add(memberVO);
        }

        return list;
    }


    public MemberVO selectOne(Long tno) throws Exception {

        String sql = "select * from test_member where tno = ?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setLong(1,tno);

        @Cleanup ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        MemberVO memberVO = MemberVO.builder()
                .tno(resultSet.getLong("tno"))
                .name(resultSet.getString("name"))
                .id(resultSet.getString("id"))
                .pw(resultSet.getString("pw"))
                .age(resultSet.getInt("age"))
                .gender(resultSet.getString("gender"))
                .hobby(resultSet.getString("hobby"))
                .travel(resultSet.getString("travel"))
                .content(resultSet.getString("content"))
                .build();

        return memberVO;
    }


    public void updateOne(MemberVO memberVO) throws Exception {

        String sql = "update test_member set name=?, id=?, pw=?, age=?, gender=?, hobby=?, travel=?, content=? where tno=?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, memberVO.getName());
        preparedStatement.setString(2, memberVO.getId());
        preparedStatement.setString(3, memberVO.getPw());
        preparedStatement.setInt(4, memberVO.getAge());
        preparedStatement.setString(5, memberVO.getGender());
        preparedStatement.setString(6, memberVO.getHobby());
        preparedStatement.setString(7, memberVO.getTravel());
        preparedStatement.setString(8, memberVO.getContent());
        preparedStatement.setLong(9, memberVO.getTno());

        preparedStatement.executeUpdate();

    }

    public void deleteOne(Long tno) throws Exception {

        String sql = "delete from test_member where tno=?";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setLong(1, tno);

        preparedStatement.executeUpdate();
    }


}
