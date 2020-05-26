// client/pages/info/info.js
var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    foodinfo: {
    },
    swiperCurrent: 0,
    indicatorDots: true,
    autoplay: true,
    interval: 3000,
    duration: 800,
    circular: true,
    contactList: [
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(e) {
    this.setData({
      foodinfo: JSON.parse(e.foodinfo)
    })
    wx.request({
      url: app.globalData.serveraddr + '/good?food=' + this.data.foodinfo.gtId,
      success: res => {
        console.log(res)
        this.setData({
          contactList:res.data.foodList
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  },
  //轮播图的切换事件

  swiperChange: function(e) {
    this.setData({
      swiperCurrent: e.detail.current

    })

  },
  goinfo: function(e) {
    var contact = this.data.contactList;
    for (var i = 0; i < contact.length;i++)
    {
      if (e.currentTarget.dataset.gid == contact[i].gid)
      {
        var food = contact[i];
        contact.splice(i,1,this.data.foodinfo);  
        this.setData({
          foodinfo: food,
          contactList:contact
        })
      }
      console.log(this.data.contactList);
    }
  },
  //点击指示点切换
  chuangEvent: function(e) {
    this.setData({
      swiperCurrent: e.currentTarget.id
    })
  },
})