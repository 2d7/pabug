/*
Navicat MySQL Data Transfer

Source Server         : 本机
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : pabug

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2022-01-06 10:07:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for site_bean
-- ----------------------------
DROP TABLE IF EXISTS `site_bean`;
CREATE TABLE `site_bean` (
  `id` int NOT NULL AUTO_INCREMENT,
  `is_unti` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `ul_class` varchar(255) DEFAULT NULL,
  `date_class` varchar(255) DEFAULT NULL,
  `text_class` varchar(255) DEFAULT NULL,
  `is_use` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of site_bean
-- ----------------------------
INSERT INTO `site_bean` VALUES ('1', '0', '安徽省科学技术厅', 'http://kjt.ah.gov.cn/kjzx/tzgg/index.html', 'doc_list', 'date', 'wzcon', '1');
INSERT INTO `site_bean` VALUES ('2', '1', '合肥市经信局', 'http://jxj.hefei.gov.cn/tzgg/index.html', 'doc_list', 'date', 'newscontnet', '1');
INSERT INTO `site_bean` VALUES ('3', '0', '安徽省经信厅', 'http://jx.ah.gov.cn/sy/wjgg/index.html', 'doc_list', 'date', 'wzcon', '1');
INSERT INTO `site_bean` VALUES ('4', '1', '安徽省发改委', 'http://fzggw.ah.gov.cn/content/column/49637171', 'doc_list', 'date', 'con_main', '1');
INSERT INTO `site_bean` VALUES ('5', '1', '安徽省商务厅', 'http://commerce.ah.gov.cn/public/column/21711?type=4&catId=28010341&action=list', 'xxgk_nav_list', 'date', 'xxgk_wenzhang', '1');
INSERT INTO `site_bean` VALUES ('6', '1', '安徽省数据资源管理局', 'http://sjzyj.ah.gov.cn/xwdt/gsgg/index.html', 'doc_list', 'date', 'con_main', '1');
INSERT INTO `site_bean` VALUES ('7', '1', '合肥市科技局', 'http://kjj.hefei.gov.cn/zwgk/tzgg/index.html', 'doc_list', 'date', 'con_main', '1');
INSERT INTO `site_bean` VALUES ('8', '1', '合肥市发改委', 'http://drc.hefei.gov.cn/zxdt/tzgg/index.html', 'doc_list', 'date', 'wenzhang', '1');
INSERT INTO `site_bean` VALUES ('9', '1', '合肥市商务局', 'http://swj.hefei.gov.cn/swdt/tzfb/index.html', 'doc_list', 'date', 'wenzhang', '1');
INSERT INTO `site_bean` VALUES ('10', '1', '合肥市数据资源局', 'http://sjzyj.hefei.gov.cn/fwdh/tzgg/index.html', 'doc_list', 'date', 'wenzhang', '1');
INSERT INTO `site_bean` VALUES ('11', '1', '合肥市高新区管委会', 'http://gxq.hefei.gov.cn/tzgg/index.html', 'doc_list', 'date', 'con_main', '1');
