<template>
  <a-layout id="components-layout-demo-top-side-2">
    <Header></Header>
    <a-layout>
      <LayoutSide></LayoutSide>
      <a-layout style="padding: 0 24px 24px" class="site-layout-background">
        <a-breadcrumb style="margin: 16px 0">
          <a-breadcrumb-item>Home</a-breadcrumb-item>
          <a-breadcrumb-item>List</a-breadcrumb-item>
          <a-breadcrumb-item>App</a-breadcrumb-item>
        </a-breadcrumb>
        <a-layout-content
            :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
        >
          所有会员总数： {{count}}
        </a-layout-content>
      </a-layout>
    </a-layout>
  </a-layout>
</template>

<script setup>
import Header from "@/components/Header.vue";
import LayoutSide from "@/components/LayoutSide.vue";
import axios from "axios";
import {notification} from "ant-design-vue";
import {ref} from "vue";

const count = ref(0);

axios.get("/member/member/count").then((response) => {
  let data = response.data;
  if (data.success){
    console.log("count:"+data.content)
    count.value = data.content;
  }else{
    notification.error({ description: data.message });
  }
});
</script>

<style scoped>
.site-layout-background {
  background: mistyrose;
}
</style>