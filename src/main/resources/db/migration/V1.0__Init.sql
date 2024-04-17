DROP TABLE IF EXISTS `address_depth1`;

CREATE TABLE `address_depth1`
(
    `id`         BIGINT      NOT NULL,
    `name`       varchar(10) NOT NULL,
    `created_at` DateTime    NOT NULL,
    `updated_at` DateTime    NOT NULL
);

DROP TABLE IF EXISTS `address_depth2`;

CREATE TABLE `address_depth2`
(
    `id`                BIGINT      NOT NULL,
    `name`              varchar(20) NOT NULL,
    `created_at`        DateTime    NOT NULL,
    `updated_at`        DateTime    NOT NULL,
    `address_depth1_id` BIGINT      NOT NULL
);

DROP TABLE IF EXISTS `place`;

CREATE TABLE `place`
(
    `id`                BIGINT       NOT NULL,
    `name`              varchar(30)  NOT NULL,
    `image`             varchar(255) NOT NULL,
    `address_detail`    varchar(100) NOT NULL,
    `point`             point        NOT NULL,
    `review_count`      INT          NOT NULL,
    `bookmark_count`    INT          NOT NULL,
    `created_at`        DateTime     NOT NULL,
    `updated_at`        DateTime     NOT NULL,
    `address_depth1_id` BIGINT       NOT NULL,
    `address_depth2_id` BIGINT       NOT NULL,
    `member_id`         BIGINT       NOT NULL
);

DROP TABLE IF EXISTS `bookmark`;

CREATE TABLE `bookmark`
(
    `id`         BIGINT   NOT NULL,
    `created_at` DateTime NOT NULL,
    `updated_at` DateTime NOT NULL,
    `place_id`   BIGINT   NOT NULL,
    `member_id`  BIGINT   NOT NULL
);

DROP TABLE IF EXISTS `review`;

CREATE TABLE `review`
(
    `id`             BIGINT        NOT NULL,
    `review_date`    DateTime      NOT NULL,
    `place_status`   varchar(50)   NOT NULL,
    `review_content` varchar(1000) NOT NULL,
    `created_at`     DateTime      NOT NULL,
    `updated_at`     DateTime      NOT NULL,
    `place_id`       BIGINT        NOT NULL,
    `member_id`      BIGINT        NOT NULL
);

DROP TABLE IF EXISTS `recommendation`;

CREATE TABLE `recommendation`
(
    `id`         BIGINT   NOT NULL,
    `created_at` DateTime NOT NULL,
    `updated_at` DateTime NOT NULL,
    `review_id`  BIGINT   NOT NULL,
    `member_id`  BIGINT   NOT NULL
);

DROP TABLE IF EXISTS `review_hashtag_map`;

CREATE TABLE `review_hashtag_map`
(
    `id`          BIGINT NOT NULL,
    `hash_tag_id` BIGINT NOT NULL,
    `review_id`   BIGINT NOT NULL
);

DROP TABLE IF EXISTS `hash_tag`;

CREATE TABLE `hash_tag`
(
    `id`   BIGINT       NOT NULL,
    `name` varchar(100) NOT NULL
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member`
(
    `id`                BIGINT       NOT NULL,
    `email`             varchar(100) NOT NULL,
    `nickname`          varchar(30)  NOT NULL,
    `profile_image_url` varchar(30)  NOT NULL,
    `oauth_id`          INT          NOT NULL,
    `oauth_provider`    varchar(20)  NOT NULL,
    `created_at`        DateTime     NOT NULL,
    `updated_at`        DateTime     NOT NULL
);

DROP TABLE IF EXISTS `review_Image`;

CREATE TABLE `review_Image`
(
    `id`         BIGINT       NOT NULL,
    `image_url`  varchar(600) NULL,
    `created_at` DateTime     NOT NULL,
    `updated_at` DateTime     NOT NULL,
    `review_id`  BIGINT       NOT NULL
);

ALTER TABLE `address_depth1`
    ADD CONSTRAINT `PK_ADDRESS_DEPTH1` PRIMARY KEY (
                                                    `id`
        );

ALTER TABLE `address_depth2`
    ADD CONSTRAINT `PK_ADDRESS_DEPTH2` PRIMARY KEY (
                                                    `id`
        );

ALTER TABLE `place`
    ADD CONSTRAINT `PK_PLACE` PRIMARY KEY (
                                           `id`
        );

ALTER TABLE `bookmark`
    ADD CONSTRAINT `PK_BOOKMARK` PRIMARY KEY (
                                              `id`
        );

ALTER TABLE `review`
    ADD CONSTRAINT `PK_REVIEW` PRIMARY KEY (
                                            `id`
        );

ALTER TABLE `recommendation`
    ADD CONSTRAINT `PK_RECOMMENDATION` PRIMARY KEY (
                                                    `id`
        );

ALTER TABLE `review_hashtag_map`
    ADD CONSTRAINT `PK_REVIEW_HASHTAG_MAP` PRIMARY KEY (
                                                        `id`
        );

ALTER TABLE `hash_tag`
    ADD CONSTRAINT `PK_HASH_TAG` PRIMARY KEY (
                                              `id`
        );

ALTER TABLE `member`
    ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
                                            `id`
        );

ALTER TABLE `review_Image`
    ADD CONSTRAINT `PK_REVIEW_IMAGE` PRIMARY KEY (
                                                  `id`
        );

