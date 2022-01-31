package com.example.swip.service.api

import com.example.swip.domain.postBoard.HomeWall
import com.example.swip.repo.UserDetailsRepo
import com.example.swip.repo.postBoard.HomeWallRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WallService(
        @Autowired
        var userDetailsRepo: UserDetailsRepo,
        @Autowired
        var homeWallRepo: HomeWallRepo
) {
        fun getSortedWall(userId: String): HomeWall{
                val wall = homeWallRepo.findByOwner(userDetailsRepo.findById(userId).get())

                wall.posts.forEach { post ->
                        post.comments.sortByDescending {
                                it.id
                        }
                }

                wall.posts.sortByDescending { it.postDate }

                return wall
        }
}