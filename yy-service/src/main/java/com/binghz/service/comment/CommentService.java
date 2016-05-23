package com.binghz.service.comment;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binghz.yy.dao.QueryDao;
import com.binghz.yy.dao.comment.CommentDao;
import com.binghz.yy.entity.common.comment.CommentEntity;

@Service
public class CommentService {
	
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private QueryDao queryDao;
	
	public List<CommentEntity> findByNewsIdAndStatus(Long newsId){
		List<CommentEntity> lists = commentDao.findByNewsIdAndStatus(newsId,1);
		return lists;
	}
	
	public List<Map<String,Object>> findUserNameComment(Long newsId){
		String sql = "select comment.commentcontent,user.nickname,comment.create_date from comment left join user on user.id=comment.userid where comment.newsid="+newsId;
		return queryDao.queryMap(sql);
	}
	
	public List<CommentEntity> findByNewsId(Long newsId){
		List<CommentEntity> lists = commentDao.findByNewsId(newsId);
		return lists;
	}
	
	public void save(CommentEntity commentEntity){
		commentDao.save(commentEntity);
	}
	
	public void update(Long commentId,Integer status){
		String sql = "update comment set status="+status+" where id="+commentId;
		queryDao.update(sql);
	}
	
	public CommentEntity findOne(Long id){
		return commentDao.findOne(id);
	}
	
	public List<Map<String,Object>> findAll(){
		String sql = "select * from comment";
		return queryDao.queryMap(sql);
	}
}
