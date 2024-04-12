<template>
  <a-layout-header class="header" id="components-layout-demo-top-side-2">
    <div class="logo" />
    <div style="float:right; color:white;">
      您好：{{member.mobile}} &nbsp; &nbsp;
      <router-link to="/login" style="color: white">
        退出登录
      </router-link>
    </div>
    <a-menu
        v-model:selectedKeys="selectedKeys1"
        theme="dark"
        mode="horizontal"
        :style="{ lineHeight: '64px' }"
    >
      <a-menu-item key="1">nav 11111</a-menu-item>
      <a-menu-item key="2">nav 2</a-menu-item>
      <a-menu-item key="3">nav 3</a-menu-item>
    </a-menu>
  </a-layout-header>
</template>

<script setup>
import {ref} from "vue";
import { useMemberStore } from '@/store';

// 可以在组件中的任意位置访问 `store` 变量 ✨
const store = useMemberStore();
let member = store.member;

const selectedKeys1 = ref(['2']);
// let member = useMemberStore().member;
// console.log("member info: "+member)

</script>

<style scoped="scoped">
#components-layout-demo-top-side-2 .logo {
  float: left;
  width: 120px;
  height: 31px;
  margin: 16px 24px 16px 0;
  background: rgba(255, 255, 255, 0.3);
}

.ant-row-rtl #components-layout-demo-top-side-2 .logo {
  float: right;
  margin: 16px 0 16px 24px;
}
</style>