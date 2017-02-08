package videogen

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.PrintWriter
import java.util.HashMap
import java.util.Random
import java.util.Scanner
import java.util.function.Consumer
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.xtext.xbase.lib.Conversions
import org.eclipse.xtext.xbase.lib.Exceptions
import org.eclipse.xtext.xbase.lib.InputOutput
import org.eclipse.xtext.xbase.lib.StringExtensions
import org.junit.Assert
import org.junit.Test
import org.tritcorp.playlist.model.Playlist.MediaFile
import org.tritcorp.playlist.model.Playlist.Playlist
import org.tritcorp.playlist.model.Playlist.PlaylistFactory
import org.tritcorp.playlist.model.Playlist.impl.PlaylistFactoryImpl
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoDescription
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import org.xtext.example.mydsl.videoGen.VideoSeq
import java.util.LinkedList
import java.util.List

@SuppressWarnings("all") class playlistTools {
	static int i = 0

	def VideoGeneratorModel loadVideoGenerator(
		URI uri) {
		var VideoGeneratorModel _xblockexpression = null
		{
			var VideoGenStandaloneSetupGenerated _videoGenStandaloneSetupGenerated = new VideoGenStandaloneSetupGenerated()
			_videoGenStandaloneSetupGenerated.createInjectorAndDoEMFRegistration()
			var ResourceSetImpl _resourceSetImpl = new ResourceSetImpl()
			var Resource res = _resourceSetImpl.getResource(uri, true)
			var EList<EObject> _contents = res.getContents()
			var EObject _get = _contents.get(0)
			_xblockexpression = ((_get as VideoGeneratorModel))
		}
		return _xblockexpression
	}

	def void saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		try {
			var ResourceSetImpl _resourceSetImpl = new ResourceSetImpl()
			var Resource rs = _resourceSetImpl.createResource(uri)
			var EList<EObject> _contents = rs.getContents()
			_contents.add(pollS)
			var HashMap<Object, Object> _hashMap = new HashMap<Object, Object>()
			rs.save(_hashMap)
		} catch (Throwable _e) {
			throw Exceptions::sneakyThrow(_e)
		}

	}

	def void concatFFMPEG() {
		try {
			var Runtime runtime = Runtime::getRuntime()
			val Process res = runtime.exec("ffmpeg.exe -f concat -i out.ffmpeg -c copy output.mp4")
		} catch (Throwable _e) {
			throw Exceptions::sneakyThrow(_e)
		}

	}

	def int genDuration(String file) {
		try {
			var Runtime runtime = Runtime::getRuntime()
			val Process res = runtime.exec(
				'''ffprobe -v error -select_streams v:0 -show_entries stream=duration -of default=noprint_wrappers=1:nokey=1 -i �file�'''.
					toString)
					var InputStream lsOut = res.getInputStream()
					var InputStreamReader isr = new InputStreamReader(lsOut)
					var BufferedReader in = new BufferedReader(isr)
					var String line
					while ((line = in.readLine()) !== null) {
						return (Double::valueOf(line).intValue())
					}
				} catch (Throwable _e) {
					throw Exceptions::sneakyThrow(_e)
				}

				return 0
			}

			def void genVignette(String file) {
				var String cmd = '''ffmpeg -i �file� -ss 00:00:01.000 -vframes 1 �file�.jpg -y'''.toString
				var Process process
				try {
					process = Runtime::getRuntime().exec(cmd)
					try {
						process.waitFor()
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace()
					}

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace()
				}

			}

			def void playlistToM3U(Playlist playlist) {
				try {
					val FileWriter fw = new FileWriter("out.m3u")
					var EList<MediaFile> _files = playlist.getFiles()
					val Consumer<MediaFile> _function = [MediaFile file |
						{
							try {
								var String _path = file.getPath()
								var File f = new File(_path)
								_path = f.getAbsolutePath()
								var String _plus = ('''�_path�
'''.toString)
								fw.write(_plus)
								fw.flush()
							} catch (Throwable _e) {
								throw Exceptions::sneakyThrow(_e)
							}

						}
					]
					_files.forEach(_function)
					fw.close()
				} catch (Throwable _e) {
					throw Exceptions::sneakyThrow(_e)
				}

			}

			def void playlistToM3UExtended(Playlist playlist) {
				try {
					val FileWriter fw = new FileWriter("out.m3u")
					fw.write("#EXTM3U")
					fw.flush()
					var EList<MediaFile> _files = playlist.getFiles()
					val Consumer<MediaFile> _function = [MediaFile file |
						{
							try {
								var String _path = file.getPath()
								var int d = genDuration(_path)
								var File f = new File(_path)
								_path = f.getAbsolutePath()
								fw.write('''#EXTINF:�d�, no-info
'''.toString)
								fw.flush()
								var String _plus = ('''�_path�
'''.toString)
								fw.write(_plus)
								fw.flush()
							} catch (Throwable _e) {
								throw Exceptions::sneakyThrow(_e)
							}

						}
					]
					_files.forEach(_function)
					fw.close()
				} catch (Throwable _e) {
					throw Exceptions::sneakyThrow(_e)
				}

			}

			def void playlistToFFMPEG(Playlist playlist) {
				try {
					val FileWriter fw = new FileWriter("out.ffmpeg")
					var EList<MediaFile> _files = playlist.getFiles()
					val Consumer<MediaFile> _function = [MediaFile file |
						{
							try {
								var String _path = file.getPath()
								var String _plus = ('''file '���_path�'''.toString)
								var String _plus_1 = ('''�_plus�'
'''.toString)
								fw.write(_plus_1)
							} catch (Throwable _e) {
								throw Exceptions::sneakyThrow(_e)
							}

						}
					]
					_files.forEach(_function)
					fw.close()
					this.concatFFMPEG()
				} catch (Throwable _e) {
					throw Exceptions::sneakyThrow(_e)
				}

			}

			def void playlistToVignettes(Playlist playlist) {
				try {
					var EList<MediaFile> _files = playlist.getFiles()
					val Consumer<MediaFile> _function = [MediaFile file |
						{
							try {
								var String _path = file.getPath()
								genVignette(_path)
							} catch (Throwable _e) {
								throw Exceptions::sneakyThrow(_e)
							}

						}
					]
					_files.forEach(_function)
				} catch (Throwable _e) {
					throw Exceptions::sneakyThrow(_e)
				}

			}

			def Playlist testM2M() {
				var URI _createURI = URI::createURI("foo2bis.videogen")
				var VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI)
				Assert::assertNotNull(videoGen)
				val PlaylistFactory plf = PlaylistFactoryImpl::init()
				val Playlist pl = plf.createPlaylist()
				var EList<VideoSeq> _videoseqs = videoGen.getVideoseqs()
				val Consumer<VideoSeq> _function = [VideoSeq videoseq |
					{
						val Random rand = new Random()
						if ((videoseq instanceof MandatoryVideoSeq)) {
							val VideoDescription desc = ((videoseq as MandatoryVideoSeq)).getDescription()
							var String _location = desc.getLocation()
							var boolean _isNullOrEmpty = StringExtensions::isNullOrEmpty(_location)
							var boolean _not = (!_isNullOrEmpty)
							if (_not) {
								var MediaFile mf = plf.createMediaFile()
								var String _location_1 = desc.getLocation()
								mf.setPath(_location_1)
								var EList<MediaFile> _files = pl.getFiles()
								_files.add(mf)
							}
						} else {
							if ((videoseq instanceof OptionalVideoSeq)) {
								val VideoDescription desc_1 = ((videoseq as OptionalVideoSeq)).getDescription()
								val int p = desc_1.getProbability()
								val int res = rand.nextInt(100)
								if ((p > 0)) {
									if (((!StringExtensions::isNullOrEmpty(desc_1.getLocation())) && (res <= p))) {
										var MediaFile mf_1 = plf.createMediaFile()
										var String _location_2 = desc_1.getLocation()
										mf_1.setPath(_location_2)
										var EList<MediaFile> _files_1 = pl.getFiles()
										_files_1.add(mf_1)
									}
								} else {
									if (((!StringExtensions::isNullOrEmpty(desc_1.getLocation())) && (res <= 50))) {
										var MediaFile mf_2 = plf.createMediaFile()
										var String _location_3 = desc_1.getLocation()
										mf_2.setPath(_location_3)
										var EList<MediaFile> _files_2 = pl.getFiles()
										_files_2.add(mf_2)
									}
								}
							} else {
								val AlternativeVideoSeq altvid = ((videoseq as AlternativeVideoSeq))
								val EList<VideoDescription> l = altvid.getVideodescs()
								val int r = ((Conversions::unwrapArray(l, typeof(Object)) as Object[])).length
								var boolean found = false
								var int pr = 0
								var EList<VideoDescription> _videodescs = altvid.getVideodescs()
								for (VideoDescription vdesc : _videodescs) {
									var int _probability = vdesc.getProbability()
									var boolean _greaterThan = (_probability > 0)
									if (_greaterThan) {
										var int _probability_1 = vdesc.getProbability()
										pr = _probability_1
									}
								}
								var int i = 0
								if ((pr === 0)) {
									do {
										{
											i = 0
											var EList<VideoDescription> _videodescs_1 = altvid.getVideodescs()
											for (VideoDescription vdesc_1 : _videodescs_1) {
												var String _location_4 = vdesc_1.getLocation()
												var boolean _isNullOrEmpty_1 = StringExtensions::
													isNullOrEmpty(_location_4)
												var boolean _not_1 = (!_isNullOrEmpty_1)
												if (_not_1) {
													var int _nextInt = rand.nextInt(r)
													val int p_1 = (_nextInt % r)
													if (((p_1 === i) && (!found))) {
														var MediaFile mf_3 = plf.createMediaFile()
														var String _location_5 = vdesc_1.getLocation()
														mf_3.setPath(_location_5)
														var EList<MediaFile> _files_3 = pl.getFiles()
														_files_3.add(mf_3)
														found = true
													}
													i++
												}
											}
										}
									} while ((!found))
								} else {
									do {
										{
											i = 0
											var EList<VideoDescription> _videodescs_1 = altvid.getVideodescs()
											for (VideoDescription vdesc_1 : _videodescs_1) {
												var String _location_4 = vdesc_1.getLocation()
												var boolean _isNullOrEmpty_1 = StringExtensions::
													isNullOrEmpty(_location_4)
												var boolean _not_1 = (!_isNullOrEmpty_1)
												if (_not_1) {
													val int p_1 = rand.nextInt(100)
													if (((p_1 <= pr) && (!found))) {
														var MediaFile mf_3 = plf.createMediaFile()
														var String _location_5 = vdesc_1.getLocation()
														mf_3.setPath(_location_5)
														var EList<MediaFile> _files_3 = pl.getFiles()
														_files_3.add(mf_3)
														found = true
													}
													i++
												}
											}
										}
									} while ((!found))
								}
							}
						}
					}
				]
				_videoseqs.forEach(_function)
				return pl
			}

			def Playlist videogenToPlaylist(String file) {
				var URI _createURI = URI::createURI(file)
				var VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI)
				Assert::assertNotNull(videoGen)
				val PlaylistFactory plf = PlaylistFactoryImpl::init()
				val Playlist pl = plf.createPlaylist()
				var EList<VideoSeq> _videoseqs = videoGen.getVideoseqs()
				val Consumer<VideoSeq> _function = [VideoSeq videoseq |
					{
						val Random rand = new Random()
						if ((videoseq instanceof MandatoryVideoSeq)) {
							val VideoDescription desc = ((videoseq as MandatoryVideoSeq)).getDescription()
							var String _location = desc.getLocation()
							var boolean _isNullOrEmpty = StringExtensions::isNullOrEmpty(_location)
							var boolean _not = (!_isNullOrEmpty)
							if (_not) {
								var MediaFile mf = plf.createMediaFile()
								var String _location_1 = desc.getLocation()
								mf.setPath(_location_1)
								var EList<MediaFile> _files = pl.getFiles()
								_files.add(mf)
							}
						} else {
							if ((videoseq instanceof OptionalVideoSeq)) {
								val VideoDescription desc_1 = ((videoseq as OptionalVideoSeq)).getDescription()
								val int p = desc_1.getProbability()
								val int res = rand.nextInt(100)
								if ((p > 0)) {
									if (((!StringExtensions::isNullOrEmpty(desc_1.getLocation())) && (res <= p))) {
										var MediaFile mf_1 = plf.createMediaFile()
										var String _location_2 = desc_1.getLocation()
										mf_1.setPath(_location_2)
										var EList<MediaFile> _files_1 = pl.getFiles()
										_files_1.add(mf_1)
									}
								} else {
									if (((!StringExtensions::isNullOrEmpty(desc_1.getLocation())) && (res <= 50))) {
										var MediaFile mf_2 = plf.createMediaFile()
										var String _location_3 = desc_1.getLocation()
										mf_2.setPath(_location_3)
										var EList<MediaFile> _files_2 = pl.getFiles()
										_files_2.add(mf_2)
									}
								}
							} else {
								val AlternativeVideoSeq altvid = ((videoseq as AlternativeVideoSeq))
								val EList<VideoDescription> l = altvid.getVideodescs()
								val int r = ((Conversions::unwrapArray(l, typeof(Object)) as Object[])).length
								var boolean found = false
								var int pr = 0
								var EList<VideoDescription> _videodescs = altvid.getVideodescs()
								for (VideoDescription vdesc : _videodescs) {
									var int _probability = vdesc.getProbability()
									var boolean _greaterThan = (_probability > 0)
									if (_greaterThan) {
										var int _probability_1 = vdesc.getProbability()
										pr = _probability_1
									}
								}
								var int i = 0
								if ((pr === 0)) {
									do {
										{
											i = 0
											var EList<VideoDescription> _videodescs_1 = altvid.getVideodescs()
											for (VideoDescription vdesc_1 : _videodescs_1) {
												var String _location_4 = vdesc_1.getLocation()
												var boolean _isNullOrEmpty_1 = StringExtensions::
													isNullOrEmpty(_location_4)
												var boolean _not_1 = (!_isNullOrEmpty_1)
												if (_not_1) {
													var int _nextInt = rand.nextInt(r)
													val int p_1 = (_nextInt % r)
													if (((p_1 === i) && (!found))) {
														var MediaFile mf_3 = plf.createMediaFile()
														var String _location_5 = vdesc_1.getLocation()
														mf_3.setPath(_location_5)
														var EList<MediaFile> _files_3 = pl.getFiles()
														_files_3.add(mf_3)
														found = true
													}
													i++
												}
											}
										}
									} while ((!found))
								} else {
									do {
										{
											i = 0
											var EList<VideoDescription> _videodescs_1 = altvid.getVideodescs()
											for (VideoDescription vdesc_1 : _videodescs_1) {
												var String _location_4 = vdesc_1.getLocation()
												var boolean _isNullOrEmpty_1 = StringExtensions::
													isNullOrEmpty(_location_4)
												var boolean _not_1 = (!_isNullOrEmpty_1)
												if (_not_1) {
													val int p_1 = rand.nextInt(100)
													if (((p_1 <= pr) && (!found))) {
														var MediaFile mf_3 = plf.createMediaFile()
														var String _location_5 = vdesc_1.getLocation()
														mf_3.setPath(_location_5)
														var EList<MediaFile> _files_3 = pl.getFiles()
														_files_3.add(mf_3)
														found = true
													}
													i++
												}
											}
										}
									} while ((!found))
								}
							}
						}
					}
				]
				_videoseqs.forEach(_function)
				return pl
			}


		def void videogenToFml(String file){
				var URI _createURI = URI::createURI(file)
				var VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI)
				Assert::assertNotNull(videoGen)
				verifyID(file)
				_createURI = URI::createURI(file+"bis.videogen")
				videoGen = this.loadVideoGenerator(_createURI)
				Assert::assertNotNull(videoGen)
				var file1 = file.replace(".videogen","")
				val FileWriter fw = new FileWriter(file1+".fml")
				var EList<VideoSeq> _videoseqs = videoGen.getVideoseqs()
				var int _size = _videoseqs.size()
				Assert::assertEquals(7, _size)
				var EList<VideoSeq> _videoseqs_1 = videoGen.getVideoseqs()
				
				fw.write("fmVideoGen = FM (VideoGen: ")
				fw.flush()
				val Consumer<VideoSeq> _function = [VideoSeq videoseq |
					{
						if ((videoseq instanceof MandatoryVideoSeq)) {
							val VideoDescription desc = ((videoseq as MandatoryVideoSeq)).getDescription()
							var String _videoid = desc.getVideoid()
							fw.write(" "+_videoid+" ")
							fw.flush()
						} else {
							if ((videoseq instanceof OptionalVideoSeq)) {
								val VideoDescription desc_1 = ((videoseq as OptionalVideoSeq)).getDescription()
								var String _videoid_1 = desc_1.getVideoid()
								
								fw.write(" ["+_videoid_1+"] ")
								fw.flush()
								
							} else {
								val AlternativeVideoSeq altvid = ((videoseq as AlternativeVideoSeq))
								var String _videoid_2 = altvid.getVideoid()
								fw.write(" "+_videoid_2+" ")
								fw.flush()
								
							}
						}
					}
				]
				_videoseqs_1.forEach(_function)
				
				
				fw.write("; ")
				fw.flush()
				
				val Consumer<VideoSeq> _function1 = [VideoSeq videoseq |
					{
						
							if ((videoseq instanceof AlternativeVideoSeq)) {
								val AlternativeVideoSeq altvid = ((videoseq as AlternativeVideoSeq))
								var String _videoid_2 = altvid.getVideoid()
								
								fw.write(_videoid_2+": (")
								fw.flush()
								
								var EList<VideoDescription> _videodescs = altvid.getVideodescs()
								var s = ""
								for (VideoDescription vdesc : _videodescs) {
									var String _videoid_3 = vdesc.getVideoid()
									s+=_videoid_3+" | "
								}
								s=s.substring(0,s.length-2)
								fw.write(s+"); ")
								fw.flush()
								
								
								
							}
					}
					
				]
				_videoseqs_1.forEach(_function1)
				
				
				fw.write(")")
				fw.flush()
				fw.close()
			}

			def Playlist videogenToPlaylistFull(String file) {
				var URI _createURI = URI::createURI(file)
				var VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI)
				Assert::assertNotNull(videoGen)
				val PlaylistFactory plf = PlaylistFactoryImpl::init()
				val Playlist pl = plf.createPlaylist()
				var EList<VideoSeq> _videoseqs = videoGen.getVideoseqs()
				val Consumer<VideoSeq> _function = [VideoSeq videoseq |
					{
						val Random rand = new Random()
						if ((videoseq instanceof MandatoryVideoSeq)) {
							val VideoDescription desc = ((videoseq as MandatoryVideoSeq)).getDescription()
							var String _location = desc.getLocation()
							var boolean _isNullOrEmpty = StringExtensions::isNullOrEmpty(_location)
							var boolean _not = (!_isNullOrEmpty)
							if (_not) {
								var MediaFile mf = plf.createMediaFile()
								var String _location_1 = desc.getLocation()
								mf.setPath(_location_1)
								var EList<MediaFile> _files = pl.getFiles()
								_files.add(mf)
							}
						} else {
							if ((videoseq instanceof OptionalVideoSeq)) {
								val VideoDescription desc_1 = ((videoseq as OptionalVideoSeq)).getDescription()
								var String _location_2 = desc_1.getLocation()
								var boolean _isNullOrEmpty_1 = StringExtensions::isNullOrEmpty(_location_2)
								var boolean _not_1 = (!_isNullOrEmpty_1)
								if (_not_1) {
									var MediaFile mf_1 = plf.createMediaFile()
									var String _location_3 = desc_1.getLocation()
									mf_1.setPath(_location_3)
									var EList<MediaFile> _files_1 = pl.getFiles()
									_files_1.add(mf_1)
								}
							} else {
								val AlternativeVideoSeq altvid = ((videoseq as AlternativeVideoSeq))
								val EList<VideoDescription> l = altvid.getVideodescs()
								var EList<VideoDescription> _videodescs = altvid.getVideodescs()
								for (VideoDescription vdesc : _videodescs) {
									var String _location_4 = vdesc.getLocation()
									var boolean _isNullOrEmpty_2 = StringExtensions::isNullOrEmpty(_location_4)
									var boolean _not_2 = (!_isNullOrEmpty_2)
									if (_not_2) {
										var MediaFile mf_2 = plf.createMediaFile()
										var String _location_5 = vdesc.getLocation()
										mf_2.setPath(_location_5)
										var EList<MediaFile> _files_2 = pl.getFiles()
										_files_2.add(mf_2)
									}
								}
							}
						}
					}
				]
				_videoseqs.forEach(_function)
				return pl
			}

			def void verifyID(String file) {
				var URI _createURI = URI::createURI(file)
				var VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI)
				Assert::assertNotNull(videoGen)
				var EList<VideoSeq> _videoseqs = videoGen.getVideoseqs()
				var int _size = _videoseqs.size()
				Assert::assertEquals(7, _size)
				var EList<VideoSeq> _videoseqs_1 = videoGen.getVideoseqs()
				val Consumer<VideoSeq> _function = [VideoSeq videoseq |
					{
						if ((videoseq instanceof MandatoryVideoSeq)) {
							val VideoDescription desc = ((videoseq as MandatoryVideoSeq)).getDescription()
							var String _videoid = desc.getVideoid()
							var boolean _isNullOrEmpty = StringExtensions::isNullOrEmpty(_videoid)
							if (_isNullOrEmpty) {
								var String _genID = this.genID()
								desc.setVideoid(_genID)
							}
						} else {
							if ((videoseq instanceof OptionalVideoSeq)) {
								val VideoDescription desc_1 = ((videoseq as OptionalVideoSeq)).getDescription()
								var String _videoid_1 = desc_1.getVideoid()
								var boolean _isNullOrEmpty_1 = StringExtensions::isNullOrEmpty(_videoid_1)
								if (_isNullOrEmpty_1) {
									var String _genID_1 = this.genID()
									desc_1.setVideoid(_genID_1)
								}
							} else {
								val AlternativeVideoSeq altvid = ((videoseq as AlternativeVideoSeq))
								var String _videoid_2 = altvid.getVideoid()
								var boolean _isNullOrEmpty_2 = StringExtensions::isNullOrEmpty(_videoid_2)
								if (_isNullOrEmpty_2) {
									var String _genID_2 = this.genID()
									altvid.setVideoid(_genID_2)
								}
								var EList<VideoDescription> _videodescs = altvid.getVideodescs()
								for (VideoDescription vdesc : _videodescs) {
									var String _videoid_3 = vdesc.getVideoid()
									var boolean _isNullOrEmpty_3 = StringExtensions::isNullOrEmpty(_videoid_3)
									if (_isNullOrEmpty_3) {
										var String _genID_3 = this.genID()
										vdesc.setVideoid(_genID_3)
									}
								}
							}
						}
					}
				]
				_videoseqs_1.forEach(_function)
				file.replace(".videogen","")
				var URI _createURI_1 = URI::createURI(file+".xmi")
				this.saveVideoGenerator(_createURI_1, videoGen)
				var URI _createURI_2 = URI::createURI(file+"bis.videogen")
				this.saveVideoGenerator(_createURI_2, videoGen) 
				/* *
				var URI _createURI_3 = URI::createURI(file+"bis.videogen")
				val VideoGeneratorModel videoGen1 = this.loadVideoGenerator(_createURI_3)
				val Playlist playlist = this.testM2M()
				InputOutput::<String>println("M3U")
				this.playlistToM3U(playlist)
				InputOutput::<String>println("\nFFMPEG")
				this.playlistToFFMPEG(playlist)
				* */
			}

			def void printVideoList(VideoGeneratorModel videoGen) {
				var EList<VideoSeq> _videoseqs = videoGen.getVideoseqs()
				val Consumer<VideoSeq> _function = [VideoSeq videoseq |
					{
						val Random rand = new Random()
						if ((videoseq instanceof MandatoryVideoSeq)) {
							val VideoDescription desc = ((videoseq as MandatoryVideoSeq)).getDescription()
							var String _location = desc.getLocation()
							var boolean _isNullOrEmpty = StringExtensions::isNullOrEmpty(_location)
							var boolean _not = (!_isNullOrEmpty)
							if (_not) {
								var String _location_1 = desc.getLocation()
								var String _plus = ('''file '���_location_1�'''.toString)
								var String _plus_1 = ('''�_plus�'��'''.toString)
								InputOutput::<String>println(_plus_1)
							}
						} else {
							if ((videoseq instanceof OptionalVideoSeq)) {
								val VideoDescription desc_1 = ((videoseq as OptionalVideoSeq)).getDescription()
								val int p = desc_1.getProbability()
								val int res = rand.nextInt(100)
								if ((p > 0)) {
									if (((!StringExtensions::isNullOrEmpty(desc_1.getLocation())) && (res <= p))) {
										var String _location_2 = desc_1.getLocation()
										var String _plus_2 = ('''file '���_location_2�'''.toString)
										var String _plus_3 = ('''�_plus_2�'��'''.toString)
										InputOutput::<String>println(_plus_3)
									}
								} else {
									if (((!StringExtensions::isNullOrEmpty(desc_1.getLocation())) && (res <= 50))) {
										var String _location_3 = desc_1.getLocation()
										var String _plus_4 = ('''file '���_location_3�'''.toString)
										var String _plus_5 = ('''�_plus_4�'��'''.toString)
										InputOutput::<String>println(_plus_5)
									}
								}
							} else {
								val AlternativeVideoSeq altvid = ((videoseq as AlternativeVideoSeq))
								val EList<VideoDescription> l = altvid.getVideodescs()
								val int r = ((Conversions::unwrapArray(l, typeof(Object)) as Object[])).length
								var boolean found = false
								var int pr = 0
								var EList<VideoDescription> _videodescs = altvid.getVideodescs()
								for (VideoDescription vdesc : _videodescs) {
									var int _probability = vdesc.getProbability()
									var boolean _greaterThan = (_probability > 0)
									if (_greaterThan) {
										var int _probability_1 = vdesc.getProbability()
										pr = _probability_1
									}
								}
								var int i = 0
								if ((pr === 0)) {
									do {
										{
											i = 0
											var EList<VideoDescription> _videodescs_1 = altvid.getVideodescs()
											for (VideoDescription vdesc_1 : _videodescs_1) {
												var String _location_4 = vdesc_1.getLocation()
												var boolean _isNullOrEmpty_1 = StringExtensions::
													isNullOrEmpty(_location_4)
												var boolean _not_1 = (!_isNullOrEmpty_1)
												if (_not_1) {
													var int _nextInt = rand.nextInt(r)
													val int p_1 = (_nextInt % r)
													if (((p_1 === i) && (!found))) {
														var String _location_5 = vdesc_1.getLocation()
														var String _plus_6 = ('''file '���_location_5�'''.toString)
														var String _plus_7 = ('''�_plus_6�'��'''.toString)
														InputOutput::<String>println(_plus_7)
														found = true
													}
													i++
												}
											}
										}
									} while ((!found))
								} else {
									do {
										{
											i = 0
											var EList<VideoDescription> _videodescs_1 = altvid.getVideodescs()
											for (VideoDescription vdesc_1 : _videodescs_1) {
												var String _location_4 = vdesc_1.getLocation()
												var boolean _isNullOrEmpty_1 = StringExtensions::
													isNullOrEmpty(_location_4)
												var boolean _not_1 = (!_isNullOrEmpty_1)
												if (_not_1) {
													val int p_1 = rand.nextInt(100)
													if (((p_1 <= pr) && (!found))) {
														var String _location_5 = vdesc_1.getLocation()
														var String _plus_6 = ('''file '���_location_5�'''.toString)
														var String _plus_7 = ('''�_plus_6�'��'''.toString)
														InputOutput::<String>println(_plus_7)
														found = true
													}
													i++
												}
											}
										}
									} while ((!found))
								}
							}
						}
					}
				]
				_videoseqs.forEach(_function)
			}

			def String printToHTML(VideoGeneratorModel videoGen) {
				val StringBuffer s = new StringBuffer()
				s.append("<html>")
				s.append("<h1>Liste des videos disponibles </h1>")
				s.append("<ul>")
				var EList<VideoSeq> _videoseqs = videoGen.getVideoseqs()
				/*
				val Consumer<VideoSeq> _function = [VideoSeq videoseq |
					{
						if ((videoseq instanceof MandatoryVideoSeq)) {
							val VideoDescription desc = ((videoseq as MandatoryVideoSeq)).getDescription()
							var String _videoid = desc.getVideoid()
							var boolean _isNullOrEmpty = StringExtensions::isNullOrEmpty(_videoid)
							var boolean _not = (!_isNullOrEmpty)
							if (_not) {
								s.append("<h2>Video obligatoire</h2>")
							}
							var String _location = desc.getLocation()
							var String _plus = ('''<li><img height="200" width="160" src="�_location�'''.toString)
							var String _plus_1 = ('''�_plus�.jpg'''.toString)
							var String _plus_2 = ('''�_plus_1�"/></li>'''.toString)
							s.append(_plus_2)
						} else {
							if ((videoseq instanceof OptionalVideoSeq)) {
								s.append("<h2>Video optionnelle</h2>")
								val VideoDescription desc_1 = ((videoseq as OptionalVideoSeq)).getDescription()
								var String _videoid_1 = desc_1.getVideoid()
								var boolean _isNullOrEmpty_1 = StringExtensions::isNullOrEmpty(_videoid_1)
								var boolean _not_1 = (!_isNullOrEmpty_1)
								if (_not_1) {
									var String _location_1 = desc_1.getLocation()
									var String _plus_3 = ('''<li><img height="200" width="160" src="�_location_1�'''.
										toString)
									var String _plus_4 = ('''�_plus_3�.jpg'''.toString)
									var String _plus_5 = ('''�_plus_4�"/></li>'''.toString)
									s.append(_plus_5)
								}
							} else {
								val AlternativeVideoSeq altvid = ((videoseq as AlternativeVideoSeq))
								var String _videoid_2 = altvid.getVideoid()
								var boolean _isNullOrEmpty_2 = StringExtensions::isNullOrEmpty(_videoid_2)
								var boolean _not_2 = (!_isNullOrEmpty_2)
								if (_not_2) {
									s.append(('''�('''<li><h2>Videos alternatives</h2>'''.toString)�</li>'''.toString))
								}
								var EList<VideoDescription> _videodescs = altvid.getVideodescs()
								var int _size = _videodescs.size()
								var boolean _greaterThan = (_size > 0)
								if (_greaterThan) {
									s.append("<ul>")
								}
								var EList<VideoDescription> _videodescs_1 = altvid.getVideodescs()
								for (VideoDescription vdesc : _videodescs_1) {
									var String _videoid_3 = vdesc.getVideoid()
									var boolean _isNullOrEmpty_3 = StringExtensions::isNullOrEmpty(_videoid_3)
									var boolean _not_3 = (!_isNullOrEmpty_3)
									if (_not_3) {
										var String _location_2 = vdesc.
											getLocation()
										var String _plus_6 = ('''<li><img height="200" width="160" src="�_location_2�'''.
											toString)
										var String _plus_7 = ('''�_plus_6�.jpg'''.toString)
										var String _plus_8 = ('''�_plus_7�"/></li>'''.toString)
										s.append(_plus_8)
									}
								}
								var EList<VideoDescription> _videodescs_2 = altvid.getVideodescs()
								var int _size_1 = _videodescs_2.size()
								var boolean _greaterThan_1 = (_size_1 > 0)
								if (_greaterThan_1) {
									s.append("</ul>")
								}
							}
						}
					}
				]*/
				//_videoseqs.forEach(_function)
				s.append("</ul>")
				s.append("</html>")
				return s.toString()
			}

			def void videoGenToHTML(String file) {
				var URI _createURI = URI::createURI(file)
				var VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI)
				var String res = printToHTML(videoGen)
				try {
					var PrintWriter writer = new PrintWriter("index.html", "UTF-8")
					writer.println(res)
					writer.flush()
					writer.close()
				} catch (IOException e) { // do something
				}

			}

			def int mp4Count(File[] files){
				val sb = new StringBuffer()
				files.forEach[file|				
					if(!file.isDirectory() && file.getPath().contains("mp4") && !file.getPath().contains("jpg"))
						sb.append("i")
				]
				return sb.length
			}

			def void videoGenFromFolder(String folder){
				val fw = new FileWriter("out.videogen")
				var res = videogenGenerator(folder,0)
				fw.write("VideoGen { \n")
				fw.flush()
				fw.write(res)
				fw.flush()
				fw.write("\n}")
				fw.flush()
				fw.close()
				
			}

			def String videogenGenerator(String file,int cpt) {
				var URI _createURI = URI::createURI(file)
				var File f = new File(file)
				
				if(f.isDirectory()){
					val s = new StringBuffer()
					val childr = f.listFiles()
					var children = childr.toList()				
					var alt = false;
					val mp4s = mp4Count(childr)
					if(childr.length==1){
						if(!children.get(0).isDirectory() && mp4s==1)
							s.append("\n mandatory videoseq vid"+cpt)
					}
					else{
						val ss = new StringBuffer()
						val mp4Path = new StringBuffer()
						children.forEach[child |
							if(child.isDirectory()){
								ss.append("1")
							}
							else
								ss.append("2")
								if(child.getPath().contains("mp4")&& !child.getPath().contains("jpg"))
									mp4Path.append(child.getPath())
						]
						if(ss.toString().contains("2") && mp4s>1){
							s.append("\n alternatives vid"+cpt+"{")
							alt = true;
						}
						else{
							s.append("\n mandatory videoseq vid"+cpt+" \""+mp4Path.toString()+"\"")
						}
					}
					//CECI EST UN COMPTEUR...... MERDE!!! -_-
					val sb = new StringBuffer()
					children.forEach[child |
						var path=child.getPath()
						
						if(!child.isDirectory()){
							if(path.contains(".mp4") && !path.contains(".jpg")&&mp4s>1){
								s.append("\n videoseq v"+cpt+""+sb.length()+" \""+path+"\"")
								sb.append("i")
							}				
						}
						else{		
							s.append(videogenGenerator(path,cpt+1))		
						}
						
					]
					if(alt)
						s.append("\n }")
						
					return s.toString()
				}
				else return ""
			}

			



			def String genID() {
				var int _plusPlus = playlistTools::i++
				return ('''v�Integer::valueOf(_plusPlus)�'''.toString)
			}
		}
		