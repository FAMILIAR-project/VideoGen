/**
 */
package playlist.tests;

import junit.textui.TestRunner;

import playlist.File;
import playlist.PlaylistFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class FileTest extends EntryTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(FileTest.class);
	}

	/**
	 * Constructs a new File test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FileTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this File test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected File getFixture() {
		return (File)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(PlaylistFactory.eINSTANCE.createFile());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //FileTest
