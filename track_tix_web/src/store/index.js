import {defineStore} from 'pinia';
import {ref} from "vue";

export const useMemberStore = defineStore('MemberStore', () => {
    let member =ref({})
    const setMember = (memberData) => {
        member.value = memberData
    }

    return {member, setMember }
})