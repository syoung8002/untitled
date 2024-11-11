<template>
    <v-card outlined>
        <v-card-title>
            UpdateContractInfo
        </v-card-title>

        <v-card-text>
            <String label="SalesId" v-model="value.salesId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="updateContractInfo"
            >
                UpdateContractInfo
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'UpdateContractInfoCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.salesId = '';
        },
        watch: {
        },
        methods: {
            updateContractInfo() {
                this.$emit('updateContractInfo', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

