package com.qk.dao;

import com.qk.bean.RfpInfoBean;
import com.qk.bean.User;
import com.qk.bean.VirtualTeamBean;
import com.qk.bean.VtMemberBean;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-5
 * Time: 下午7:06
 * To change this template use File | Settings | File Templates.
 */
public interface VirtualTeamDao {
    public VirtualTeamBean infoFindById(Integer id);

    /**
     * 通过团队招标id获取团队信息, 此方法会返回团队信息和成员信息列表，
     * 所以需要传两个对象给此方法，方法会自动填充对象
     *
     * @param id 团队招标rfp_info_id
     * @return 返回的键值对为：memberList=memberList成员列表对象   virtualTeamBean=virtualTeamBean团队对象 status=status
     */
    public Map<String, Object> getByRfpId(Integer id);

    /**
     * 新增一个团队
     *
     * @param virtualTeamBean
     * @return
     */
    public int insertTeam(VirtualTeamBean virtualTeamBean, User user);

    /**
     * 删除一个团队
     *
     * @param teamId
     * @return
     */
    public int deleteTeam(Integer teamId);

    /**
     * 更新团队基本信息
     *
     * @param virtualTeamBean
     * @return
     */
    public int updateTeam(VirtualTeamBean virtualTeamBean);

    /**
     * 新加入一个成员
     *
     * @return
     */
    public int addOneMember(VtMemberBean memberBean, User user);

    /**
     * 删除一个成员
     *
     * @param teamId   团队id
     * @param memberId 成员UserId
     * @return
     */
    public int delOneMember(Integer teamId, Integer memberId, User user);

    /**
     * 退出团队
     *
     * @return
     */
    public int outTeam(Integer teamId, Integer userId);

    /**
     * 更新团队成员，会将原来成员全部删除，然后更新为memberIdList
     *
     * @param teamId
     * @param memberIdList 成员id列表
     * @param user         团队创建者
     * @return
     */
    public int updateMember(Integer teamId, List<Integer> memberIdList, User user);

    /**
     * 获取userId创建的所有团队
     *
     * @param userId
     * @return
     */
    public List<VirtualTeamBean> getMyTeamByUserId(Integer pageNumber, Integer pageSize, Integer userId);

    public Integer getCount(Integer userId);

    /**
     * 获取userId所参加的所有团队
     *
     * @param userId
     * @return
     */
    public List<VirtualTeamBean> getMyJoinTeam(Integer pageNumber, Integer pageSize, Integer userId);
}
